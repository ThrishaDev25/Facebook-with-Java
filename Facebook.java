package guru.edu.facebook;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class Facebook {
	static boolean b = true, confirm = false, c;
	static String user_entered_pwd;
	static String user_entered_email;
	static String login_user_name;
	static String login_user_pwd;
	static LocalTime currenttime;
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		do {
			System.out.println("\t\t\t\t*******Welcome to facebook********");
			System.out.println("1.signup\n2.login");
			int user = s.nextInt();
			switch (user) {
			case 1: {

				System.out.println("1.Enter your Username");
				s.nextLine();
				user_entered_email = s.nextLine();
				c = false;
				System.out.println("2.Enter your password");
				user_entered_pwd = s.nextLine();
				if (user_entered_pwd.length() <= 8) {
					Thread.sleep(500);
					verification();
					break;
				} else {
					System.out.println("Password must be 8 characters");
					break;
				}

			}
			case 2: {
				if (confirm) {
					System.out.println("1.Enter your Username");
					s.nextLine();
					login_user_name = s.nextLine();
					System.out.println("1.Enter your password");
					login_user_pwd = s.nextLine();
					File file = new File("D://User.txt");
					try(FileWriter){

						if (file.createNewFile()) {
						} else {
							System.out.println("file not created");

						}
						LocalTime Currentime = LocalTime.now();
						FileWriter writer = new FileWriter(file);
						writer.write("username :" + login_user_name + "\n");
						writer.write("password :" + login_user_pwd + "\n");
						writer.write("login Time :" + Currentime);
						

					} catch (IOException e) {

					}
					if (login_user_name.equals(user_entered_email) && login_user_pwd.equals(user_entered_pwd)) {
						System.out.println("login sucessful and Acoount created");
					} else {
						System.out.println("Invalid Username or Password");
					}

				} else {
					System.out.println("You Are New to Facebook Please Signup First");
				}

				break;
			}

			}
		} while (b);

	}

	public static void verification() throws Exception {
		System.out.println(">>>>please wait otp will be send to your registered mobile number or mail id:");
		double sys_otp = Math.random() * 999 + 999;
		int otp = (int) sys_otp;
		Thread.sleep(500);
		System.out.println("Facebook generated otp:" + otp);
		Thread.sleep(3000);
		System.out.println("processing... please wait");
		Thread.sleep(3000);
		System.out.println("please Enter your otp");
		int user_entered_otp = s.nextInt();
		if (user_entered_otp == otp) {
			confirm = true;
			Thread.sleep(500);
			System.out.println("Thankyou for your response & signup successful");
		} else {
			System.out.println("\t\t\t********Verification Denied*********");
		}

	}

}
