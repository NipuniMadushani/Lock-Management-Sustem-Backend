package lk.esoft.batch18.lockhoodmanagementsystem;

import lk.esoft.batch18.lockhoodmanagementsystem.models.*;
import lk.esoft.batch18.lockhoodmanagementsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	public static void main(String[] args) {
    SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(companyRepo.findAll().size()<=0) {
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

		if(plantRepo.findAll().size()<=0){
			Plant plant = new Plant(
					1,
					"Moratuwa",
					"plantLock",
					"0090998900"
			);
			plantRepo.save(plant);

		}
		if(factoryRepo.findAll().size()<=0){
			Factory factory = new Factory(
					1,
					"factory",
					"goodType",
					plantRepo.getById(2)
			);
			factoryRepo.save(factory);
		}

		if(departmentRepo.findAll().size()<=0){
			Department department = new Department(
					1,
					"department1",
					100,
					factoryRepo.getById(3)
			);
			departmentRepo.save(department);
		}
		if(workshopRepo.findAll().size()<=0){
			Workshop workshop = new Workshop(
					1,
					"work",
					"panadura",
					"wo@gmail.com",
					factoryRepo.getById(3)
			);
			workshopRepo.save(workshop);
		}
		if (roleRepository.findAll().size()<=0) {
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
			List<Role> roleList = new ArrayList<>();
			roleList.add(role);
			roleList.add(role1);
			roleList.add(role2);
			roleList.add(role3);
			roleList.add(role4);
			roleRepository.saveAll(roleList);
		}
	}
}


