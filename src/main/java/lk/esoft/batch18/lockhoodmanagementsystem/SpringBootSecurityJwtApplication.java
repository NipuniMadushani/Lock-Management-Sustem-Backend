package lk.esoft.batch18.lockhoodmanagementsystem;

import lk.esoft.batch18.lockhoodmanagementsystem.models.*;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@SpringBootApplication
@EnableSwagger2
public class SpringBootSecurityJwtApplication implements CommandLineRunner {
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private CompanyRepo companyRepo;

	@Autowired
	private PlantRepo plantRepo;

	@Autowired
	private FactoryRepo factoryRepo;

	@Autowired
	private DepartmentRepo departmentRepo;

	@Autowired
	private WorkshopRepo workshopRepo;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
    SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (companyRepo.findAll().size() <= 0) {
			LocalDateTime localDateTime = LocalDateTime.now();
			LocalDate localDate = localDateTime.toLocalDate();
			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			Company company = new Company(
					"Malinga Lakshan",
					"001223444br",
					"Moratuwa",
					772163479,
					"Malinga",
					date,
					"Lakshan",
					date
			);

			companyRepo.save(company);
		}

		if (plantRepo.findAll().size() <= 0) {
			Plant plant = new Plant(
					1,
					"Moratuwa",
					"plantLock",
					"0090998900"
			);
			plantRepo.save(plant);

		}
		if (factoryRepo.findAll().size() <= 0) {
			Factory factory = new Factory(
					1,
					"factory",
					"goodType",
					plantRepo.getById(2)
			);
			factoryRepo.save(factory);
		}

		if (departmentRepo.findAll().size() <= 0) {
			Department department = new Department(
					1,
					"department1",
					100,
					factoryRepo.getById(3)
			);
			departmentRepo.save(department);
		}
		if (workshopRepo.findAll().size() <= 0) {
			Workshop workshop = new Workshop(
					1,
					"work",
					"panadura",
					"wo@gmail.com",
					factoryRepo.getById(3),
					null
			);
			workshopRepo.save(workshop);
		}
		if (roleRepository.findAll().size() <= 0) {
			Role role = new Role(
					1,
					ERole.ROLE_USER
			);
			Role role1 = new Role(
					2,
					ERole.ROLE_ADMIN
			);
			Role role2 = new Role(
					3,
					ERole.ROLE_SUPERVISOR
			);
			Role role3 = new Role(
					4,
					ERole.ROLE_ADMIN_ENGINEERING
			);
			Role role4 = new Role(
					5,
					ERole.ROLE_ADMIN_PURCHASE_OFFICE
			);
			Role role5 = new Role(
					5,
					ERole.CUSTOMER
			);
			List<Role> roleList = new ArrayList<>();
			roleList.add(role);
			roleList.add(role1);
			roleList.add(role2);
			roleList.add(role3);
			roleList.add(role4);
			roleList.add(role5);
			roleRepository.saveAll(roleList);
		}
		if (!userRepository.existsByUsername("malinga")) {
			Set<Role> roles = new HashSet<>();
			Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(adminRole);
			User user = new User(
					1,
					"malinga",
					"mali@gmail.com",
					encoder.encode("12345"),
					//signUpRequest.getPassword(),
					roles,
					"Malinga",
					"Moratuwa",
					"malicom@gmail.com",
					77885555,
					true,
					"19974556",
					"WA",
					"Lakshan",
					"www.firebase.com/etrtryu7677888hgyf666",
					"user",
					null,
					"user",
					null,
					null,
					departmentRepo.getById(4),
					null,
					null
			);
			userRepository.save(user);
		}


		if (!userRepository.existsByUsername("nipuni")) {
			Set<Role> roles = new HashSet<>();
			Role adminRole = roleRepository.findByName(ERole.ROLE_SUPERVISOR)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(adminRole);
			User user = new User(
					1,
					"nipuni",
					"nipuni@gmail.com",
					encoder.encode("12345"),
					//signUpRequest.getPassword(),
					roles,
					"Nipuni",
					"Mathugama",
					"nipunicom@gmail.com",
					77885555,
					true,
					"19974556",
					"AS",
					"Chamika",
					"www.firebase.com/etrtryu7677888hgyf666",
					"user",
					null,
					"user",
					null,
					null,
					departmentRepo.getById(4),
					null,
					null
			);
			userRepository.save(user);
		}

		if (!userRepository.existsByUsername("lihini")) {
			Set<Role> roles = new HashSet<>();
			Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN_ENGINEERING)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(adminRole);
			User user = new User(
					1,
					"lihini",
					"lihini@gmail.com",
					encoder.encode("12345"),
					//signUpRequest.getPassword(),
					roles,
					"lihini",
					"colombo",
					"nipunicom@gmail.com",
					77885555,
					true,
					"19974556",
					"AS",
					"Chamika",
					"www.firebase.com/etrtryu7677888hgyf666",
					"user",
					null,
					"user",
					null,
					null,
					departmentRepo.getById(4),
					null,
					null
			);
			userRepository.save(user);
		}

		if (!userRepository.existsByUsername("thushen")) {
			Set<Role> roles = new HashSet<>();
			Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN_ENGINEERING)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(adminRole);
			User user = new User(
					1,
					"thushen",
					"thushen@gmail.com",
					encoder.encode("12345"),
					//signUpRequest.getPassword(),
					roles,
					"thushen",
					"colombo",
					"thushencom@gmail.com",
					77885555,
					true,
					"19974556",
					"AS",
					"thushen",
					"www.firebase.com/etrtryu7677888hgyf666",
					"user",
					null,
					"user",
					null,
					null,
					departmentRepo.getById(4),
					null,
					null
			);
			userRepository.save(user);
		}

		if (!userRepository.existsByUsername("sara")) {
			Set<Role> roles = new HashSet<>();
			Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN_ENGINEERING)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(adminRole);
			User user = new User(
					1,
					"sara",
					"sara@gmail.com",
					encoder.encode("12345"),
					//signUpRequest.getPassword(),
					roles,
					"sara",
					"colombo",
					"saracom@gmail.com",
					77885555,
					true,
					"19974556",
					"AS",
					"sara",
					"www.firebase.com/etrtryu7677888hgyf666",
					"user",
					null,
					"user",
					null,
					null,
					departmentRepo.getById(4),
					null,
					null
			);
			userRepository.save(user);
		}

		if (!userRepository.existsByUsername("thami")) {
			Set<Role> roles = new HashSet<>();
			Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN_PURCHASE_OFFICE)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(adminRole);
			User user = new User(
					1,
					"thami",
					"thami@gmail.com",
					encoder.encode("12345"),
					//signUpRequest.getPassword(),
					roles,
					"thami",
					"colombo",
					"thamicom@gmail.com",
					77885555,
					true,
					"19974556",
					"AS",
					"thami",
					"www.firebase.com/etrtryu7677888hgyf666",
					"user",
					null,
					"user",
					null,
					null,
					departmentRepo.getById(4),
					null,
					null
			);
			userRepository.save(user);
		}

		if (!userRepository.existsByUsername("sunil")) {
			Set<Role> roles = new HashSet<>();
			Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN_PURCHASE_OFFICE)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(adminRole);
			User user = new User(
					1,
					"sunil",
					"sunil@gmail.com",
					encoder.encode("12345"),
					//signUpRequest.getPassword(),
					roles,
					"sunil",
					"colombo",
					"sunilcom@gmail.com",
					77885555,
					true,
					"19974556",
					"AS",
					"sunil",
					"www.firebase.com/etrtryu7677888hgyf666",
					"user",
					null,
					"user",
					null,
					null,
					departmentRepo.getById(4),
					null,
					null
			);
			userRepository.save(user);
		}
	}
}


