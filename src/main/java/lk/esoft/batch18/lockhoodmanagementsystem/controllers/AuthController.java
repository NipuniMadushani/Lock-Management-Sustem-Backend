package lk.esoft.batch18.lockhoodmanagementsystem.controllers;

import lk.esoft.batch18.lockhoodmanagementsystem.dto.response.GetUserDTO;
import lk.esoft.batch18.lockhoodmanagementsystem.models.*;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.paginated.PaginatedUsers;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.request.LoginRequest;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.request.SignupRequest;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.response.JwtResponse;
import lk.esoft.batch18.lockhoodmanagementsystem.payload.response.MessageResponse;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.*;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin
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

    @Autowired
    private DepartmentRepo departmentRepo;

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
        Company company = companyRepo.findById(signUpRequest.getCompanyId()).get();
        Plant plant = plantRepo.findById(signUpRequest.getPlantId()).get();


        // Create new user's account
        User user = new User(
                1,
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                //signUpRequest.getPassword(),
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
                plantRepo.findById(signUpRequest.getPlantId()).get(),
                null,
                departmentRepo.getById(signUpRequest.getDepartmentId())
        );


        Set<Role> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);


        } else {
            strRoles.forEach(role -> {
                switch (role.getName().name()) {
                    case "ROLE_ADMIN":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    case "ROLE_SUPERVISOR":
                        Role supRole = roleRepository.findByName(ERole.ROLE_SUPERVISOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(supRole);
                        break;

                    case "ROLE_ADMIN_ENGINEERING":
                        Role rae = roleRepository.findByName(ERole.ROLE_ADMIN_ENGINEERING)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(rae);

                        break;

                    case "ROLE_ADMIN_PURCHASE_OFFICE":
                        Role rapo = roleRepository.findByName(ERole.ROLE_ADMIN_PURCHASE_OFFICE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(rapo);

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
            path = {"/get-all-users"}
    )
    public ResponseEntity<StandardResponse> getAllItems() {
        int page = 0;
        int size = 1000;
        PaginatedUsers users = userService.getAllUsers(page, size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", users),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-by-id-active",
            params = "id")
    public ResponseEntity<StandardResponse> getUserByIdActive(@RequestParam(value = "id") Long userId) {
        boolean b = true;
        GetUserDTO getUserDTO = userService.getUserByIdActive(userId, b);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", getUserDTO),
                HttpStatus.OK
        );

    }


}
