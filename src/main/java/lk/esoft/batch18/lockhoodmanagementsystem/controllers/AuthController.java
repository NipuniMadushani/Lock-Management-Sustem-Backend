package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.models.ERole;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Role;
import lk.esoft.batch18.lockhoodmanagementsystem.models.User;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.paginated.PaginatedUsers;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.request.LoginRequest;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.request.SignupRequest;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.response.JwtResponse;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.response.MessageResponse;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.CompanyRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.PlantRepo;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.RoleRepository;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.UserRepository;
import lk.esoft.batch18.lockhoodmanagementsystem.security.jwt.JwtUtils;
import lk.esoft.batch18.lockhoodmanagementsystem.security.services.UserDetailsImpl;
import lk.esoft.batch18.lockhoodmanagementsystem.service.UserService;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private PlantRepo plantRepo;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(
                1L,
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                null,
                signUpRequest.getFirstName(),
                signUpRequest.getAddress(),
                signUpRequest.getCompanyEmail(),
                signUpRequest.getContactNumber(),
                signUpRequest.isActiveState(),
                signUpRequest.getNic(),
                signUpRequest.getMName(),
                signUpRequest.getLastName(),
                signUpRequest.getImage(),
                signUpRequest.getCreatedBy(),
                signUpRequest.getCreatedDate(),
                signUpRequest.getUpdatedBy(),
                signUpRequest.getUpdatedDate(),
                companyRepo.findById(signUpRequest.getCompanyId()).get(),
                 plantRepo.findById(signUpRequest.getPlantId()).get());




        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @GetMapping(
            path = {"/get-all-users"},
            params = {"page", "size"}
    )
    public ResponseEntity<StandardResponse> getAllItems(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
            ) {
        PaginatedUsers users = userService.getAllUsers(page, size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", users),
                HttpStatus.OK
        );
    }


}
