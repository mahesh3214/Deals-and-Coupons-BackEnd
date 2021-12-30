package springbootgateway.controller;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;*/
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	/*
	 * @Autowired private RestTemplate restTemplate;
	 */

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('COMPANY') or hasRole('ADMIN')")
	public String userAccess() {
		return "user data";
	}

	@GetMapping("/company")
	@PreAuthorize("hasRole('COMPANY')")
	public String companyAccess() {
		return "company Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
