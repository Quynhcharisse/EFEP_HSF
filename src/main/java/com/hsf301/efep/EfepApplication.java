package com.hsf301.efep;

import com.hsf301.efep.enums.Role;
import com.hsf301.efep.enums.Status;
import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.User;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class EfepApplication {

	private final AccountRepo accountRepo;

	private final UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(EfepApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Account customer = accountRepo.save(Account.builder()
								.email("test@gmail.com")
								.password("123")
								.role(Role.ACCOUNT_CUSTOMER)
						.build());


				User user = userRepo.save(User.builder()
								.account(customer)
								.name("test")
								.phone("0987654321")
								.avatar("")
								.background("")
								.createdDate(LocalDate.now())
						.build());
			}
		};
	}

}
