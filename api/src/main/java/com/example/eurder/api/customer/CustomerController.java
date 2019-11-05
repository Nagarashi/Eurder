package com.example.eurder.api.customer;

import com.example.eurder.api.customer.dtos.AddressDto;
import com.example.eurder.api.customer.dtos.CreateCustomerDto;
import com.example.eurder.api.customer.dtos.CustomerDto;
import com.example.eurder.api.customer.dtos.EmailDto;
import com.example.eurder.domain.customer.Address;
import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.customer.Email;
import com.example.eurder.service.customer.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "eurder/customers")
public class CustomerController {

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private CustomerService customerService;
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomers() {
        logger.info("GET request for all customers");
        return customerService.getAllCustomers().stream()
                .map(customer -> customerMapper.mapCustomerToDto(customer))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerBasedOnId(@PathVariable String id) {
        logger.info("GET request with id mapping to id : {} ", id);
        return customerMapper.mapCustomerToDto(customerService.getCustomerById(id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CreateCustomerDto createCustomerDto) {
        logger.info("POST request for a single customer ");
        if (isValidInput(createCustomerDto)) {
            AddressDto address = createCustomerDto.getAddress();
            Address myAddress = new Address(address.getStreet(), address.getHouseNumber(), address.getZipCode(), address.getCity());

            EmailDto email = createCustomerDto.getEmail();
            Email myEmail = new Email(email.getAddress(), email.getDomain());

            return customerMapper.mapCustomerToDto(
                    customerService.addCustomer(new Customer(
                            createCustomerDto.getFirstName(),
                            createCustomerDto.getLastName(),
                            myEmail,
                            myAddress,
                            createCustomerDto.getPhoneNumber()))
            );
        }
        logger.error("Invalid POST request, customer data is incomplete or invalid");
        throw new IllegalArgumentException(
                "Customer data is invalid, please provide a valid email, last name and address");

    }

    private boolean isValidInput(CreateCustomerDto customerDto) {
        return customerDto.getEmail() != null
                && customerDto.getLastName() != null
                && customerDto.getAddress() != null;
    }
}
