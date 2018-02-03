package com.itforhumanity.food_app.bootstrap;

import com.itforhumanity.food_app.entities.Address;
import com.itforhumanity.food_app.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        initData();

    }

    public void initData(){

        Address address = new Address();
        address.setTown("Vyjebanec");
        address.setStreet("Zajebanec");
        address.setHouseNumber(666);
        address.setPostalCode(66666);

        addressRepository.save(address);

        Address address2 = new Address();
        address2.setTown("Richov");
        address2.setStreet("Lol");
        address2.setHouseNumber(666);
        address2.setPostalCode(66666);

        addressRepository.save(address2);

        Address address3 = new Address();
        address3.setTown("MalejKokot");
        address3.setStreet("Demeter");
        address3.setHouseNumber(666);
        address3.setPostalCode(66666);

        addressRepository.save(address3);

        Address address4 = new Address();
        address4.setTown("VyhulMiHo");
        address4.setStreet("TedHned");
        address4.setHouseNumber(666);
        address4.setPostalCode(66666);


        addressRepository.save(address4);




    }
}
