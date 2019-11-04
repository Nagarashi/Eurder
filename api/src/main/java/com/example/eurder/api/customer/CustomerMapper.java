package com.example.eurder.api.customer;

import com.example.eurder.api.customer.dtos.AddressDto;
import com.example.eurder.api.customer.dtos.CustomerDto;
import com.example.eurder.api.customer.dtos.EmailDto;
import com.example.eurder.domain.customer.Address;
import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.customer.Email;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto mapMemberToDto(Customer customer) {
        return new CustomerDto()
                .setid(customer.getId())
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setEmail(mapEmailToDto(customer.getEmail()))
                .setAddress(mapAddressToDto(customer.getAddress()))
                .setPhoneNumber(customer.getPhoneNumber());
    }

    private EmailDto mapEmailToDto(Email email) {
        return new EmailDto()
                .setAddress(email.getAddress())
                .setDomain(email.getDomain());
    }

    private AddressDto mapAddressToDto (Address address) {
        return new AddressDto()
                .setStreet(address.getStreet())
                .setHouseNumber(address.getHouseNumber())
                .setZipCode(address.getZipCode())
                .setCity(address.getCity());
    }


}
