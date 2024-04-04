package edu.iu.habahram.ducksservice.controllers;

import edu.iu.habahram.ducksservice.model.Customer;
import edu.iu.habahram.ducksservice.repository.CustomerRepository;
import edu.iu.habahram.ducksservice.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationManager authManager;

    private final TokenService tokenService;

    CustomerRepository customerRepository;
    public AuthenticationController(AuthenticationManager authManager,
                                            TokenService tokenService,
                                            CustomerRepository
                                            customerRepository) {
        this.authManager = authManager;
        this.tokenService = tokenService;
        this.customerRepository = customerRepository;

    }
    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/signin")
    public String signin(@RequestBody Customer customer) {
        Authentication authentication = authManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                customer.username()
                                , customer.password()));
        return tokenService.generateToken(authentication);
    }
}
