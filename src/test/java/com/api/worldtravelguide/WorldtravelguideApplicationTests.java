package com.api.worldtravelguide;

import com.api.worldtravelguide.domain.country.Country;
import com.api.worldtravelguide.domain.country.CountryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorldtravelguideApplicationTests {
    @Autowired
    CountryRepository countryRepository;

    @Test
    public void contextLoads() {
        List<Country> country = countryRepository.findAllByDeletedFalse();
        System.out.println(country);
    }

}
