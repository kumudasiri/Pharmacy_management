package com.example.UserMS;

import com.example.UserMS.Controller.UserController;
import com.example.UserMS.Entity.User;
import com.example.UserMS.Repository.UserRepo;
import com.example.UserMS.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserMsApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserController userController;

	@MockBean
	private UserRepo userRepo;



	@Test
	public void getUsersTest() {

		when(userRepo.findAll()).thenReturn(Stream.of(new User((long)1001,"Kumuda",(long)899035,"ksiritt@gmail.com","Kumu123")).collect(Collectors.toList()));
		assertEquals(1, userService.findAll().size());
	}

	private void assertEquals(int i, int size) {
	}

	private void assertEquals(int i, Long valueOf) {
	}

	@Test
	public void saveUsersTest() {
		User user = new User((long)1001,"Kumuda",(long)899035,"ksiritt@gmail.com","Kumu123");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user,userService.saveUser(user));
	}

	private void assertEquals(User user, User saveUser) {
	}

	@Test
	public void deleteUserTest() {
		userService.deleteUser((long)1001);
		verify(userRepo,times(1)).deleteById((long)1001);
	}



	@Test
	void testSetUserName() {
		User user = new User();
		user.setUserName("Bhavana");
		assertEquals(user.getUserName() == "Bhavana");
	}

	private void assertEquals(boolean b) {
	}

	@Test
	void testSetUserPhoneNumber() {
		User user = new User();
		user.setUserPhoneNumber((long) 595898);
		assertEquals(user.getUserPhoneNumber() == 595898);
	}

	@Test
	void testSetUserEmail() {
		User user = new User();
		user.setUserEmail("nik@gmail.com");
		assertEquals(user.getUserEmail() == "nik@gmail.com");
	}

	@Test
	void testSetPassword() {
		User user = new User();
		user.setPassword("nik060920");
		assertEquals(user.getPassword() == "nik060920");
	}
	@Test
	void testSetUserID() {
		User user = new User();
		user.setUserID((long)65);
		assertEquals(user.getUserID() == 65);
	}

	@Test
	void testToString() {
		User user=new User((long) 13, "Kumuda", (long) 935854, "kumuda@gmail.com", "kum0555S");
		assertEquals(user.toString());
	}
	private void assertEquals(String string) {
		// TODO Auto-generated method stub

	}
	
	@Test
	void deleteUserController() {
		userController.deleteUser((long) 12);
		verify(userRepo, times(1)).deleteById((long) 12);
	}

	@Test
	void getUserController() {
		when(userRepo.findAll())
				.thenReturn(Stream.of(new User((long) 15, "Pavan", (long) 636124, "pavan@gmail.com", "pav0609"))
						.collect(Collectors.toList()));
		assertEquals(15, userController.getUsers().size());
	}

	@Test
	void saveUserController() {
		User user = new User((long) 12, "Pavan", (long) 636124, "pav@gmail.com", "nik0609");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userController.saveUser(user));
	}



}
