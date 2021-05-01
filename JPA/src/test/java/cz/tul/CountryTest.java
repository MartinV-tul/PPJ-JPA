package cz.tul;

import cz.tul.data.Country;
import cz.tul.service.CountryService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Main.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountryTest {

    @Autowired
    private CountryService countryService;

    private Country country1 = new Country("Česká Republika");
    private Country country2 = new Country("Slovensko");


    @Before
    public void init() {
        countryService.deleteAllCountries();
    }

    @Test
    public void testCreateCountry(){
        countryService.create(country1);

        List<Country> countries1 = countryService.getAllCountries();

        System.out.println(countries1);

        assertEquals("One country should have been created and retrieved", 1, countries1.size());
        assertEquals("Inserted country should match retrieved", country1, countries1.get(0));

        countryService.create(country2);

        List<Country> countries2 = countryService.getAllCountries();
        assertEquals("Should be two retrieved countries.", 2, countries2.size());
    }

    @Test
    public void testExists(){
        countryService.create(country1);
        countryService.create(country2);
        assertTrue("Country should exist.", countryService.exists(country1.getCountryName()));
        assertFalse("Country should not exist.", countryService.exists("aaabbbccc"));
    }

    @Test
    public void testDelete(){
        countryService.create(country1);
        countryService.create(country2);
        assertTrue("Country1 should exist.", countryService.exists(country1.getCountryName()));
        countryService.deleteCountry(country1);
        assertFalse("Country1 should no longer exist.", countryService.exists(country1.getCountryName()));
    }

}
