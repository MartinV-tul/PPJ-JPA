package cz.tul.repositories;

import cz.tul.data.Town;
import cz.tul.data.TownID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TownRepository extends CrudRepository<Town, TownID> {

    @Query("select t from Town as t where t.countryName=:countryName")
    public List<Town> findByCountryName(@Param("countryName") String countryName);
}
