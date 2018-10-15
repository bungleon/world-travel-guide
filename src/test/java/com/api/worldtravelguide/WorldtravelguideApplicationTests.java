package com.api.worldtravelguide;

import com.api.worldtravelguide.domain.country.Country;
import com.api.worldtravelguide.domain.country.CountryRepository;
import com.api.worldtravelguide.domain.town.Town;
import com.api.worldtravelguide.message.custom.CountrySearch;
import com.api.worldtravelguide.message.custom.ProvinceSearch;
import com.api.worldtravelguide.message.custom.TownSearch;
import com.api.worldtravelguide.message.custom.request.SearchRequest;
import com.api.worldtravelguide.message.dto.TownDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorldtravelguideApplicationTests {
    @Autowired
    CountryRepository countryRepository;

    @Test
    public void contextLoads() {
       /* Object country = countryRepository.search(String.class, "Erman", "Osman");
        System.out.println(country);*/
    }


    @Test
    public void test() {
        Country country = new Country();
        country.setName("Osman");
        Country country1 = new Country();
        country1.setName("Osman");
        if (country.getName().hashCode() == country1.getName().hashCode()) {
            System.out.println("OK");
        } else {
            System.out.println("FUUUUUUUUUU");
        }
    }

    @Test
    public void objectTest() {
        CountrySearch countrySearch = new CountrySearch();
        //countrySearch.setName("Turkey");
        //countrySearch.setBinaryCode("TR");
        ProvinceSearch provinceSearch = new ProvinceSearch();
        //provinceSearch.setName("Bursa");
        provinceSearch.setPhoneCode("null");
        provinceSearch.setCountry(countrySearch);
        TownSearch townSearch = new TownSearch();
        townSearch.setProvince(provinceSearch);

        SearchRequest request = new SearchRequest();
        request.setPageNumber(1);
        request.setEqualsNull(townSearch);
        Page<TownDto> towns = countryRepository.search(TownDto.class, Town.class, request);
        List<TownDto> townDtoList = towns.getContent();
        System.out.println(townDtoList.toString());
    }

    @Test
    public void testtttt() {
        String s = "osman ben";
        String s1 = "sen kim";
        s.concat(s1);
        System.out.println(s);
        System.out.println(s1);
    }

}
