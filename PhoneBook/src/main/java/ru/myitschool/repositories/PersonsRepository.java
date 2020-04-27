package ru.myitschool.repositories;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.myitschool.entity.Persons;

@Component
public class PersonsRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int createPerson(String name) {
		return jdbcTemplate.update("INSERT INTO dbtest.\"PERSONS\" (\"NAME\") VALUES(?)", name);
	}

	public int updatePerson(Persons person) {
		return jdbcTemplate.update("UPDATE dbtest.\"PERSONS\" SET \"NAME\" = ? WHERE \"ID\" = ?", person.getName(),
				person.getId());
	}

	public int deletePerson(Integer id) {
		return jdbcTemplate.update("DELETE FROM dbtest.\"PERSONS\" WHERE \"ID\" = ?", id);
	}

	public Persons getPerson(Integer id) {
		return jdbcTemplate.queryForObject("SELECT * FROM dbtest.\"PERSONS\" WHERE \"ID\"=?" , new PersonsMapper(), id);
	}

	public List<Persons> getPersons() {
		return jdbcTemplate.query("SELECT * FROM dbtest.\"PERSONS\"", new PersonsMapper());
	}
}