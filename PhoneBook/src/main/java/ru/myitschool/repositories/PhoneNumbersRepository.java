package ru.myitschool.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.myitschool.entity.PhoneNumbers;

@Component
public class PhoneNumbersRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int createPhoneNumber(Long value, Integer idPerson) {
		return jdbcTemplate.update("INSERT INTO dbtest.\"PHONENUMBERS\" (\"VALUE\", \"ID_PERSON\") VALUES (?,?)", value,
				idPerson);
	}

	public int updatePhoneNumber(PhoneNumbers phoneNumbers) {
		return jdbcTemplate.update("UPDATE dbtest.\"PHONENUMBERS\" SET \"VALUE\" = ? WHERE \"ID\" = ?",
				phoneNumbers.getValue(), phoneNumbers.getId());
	}

	public int deletePhoneNumbers(Integer id) {
		return jdbcTemplate.update("DELETE FROM dbtest.phonenumbers WHERE \"ID\" = ?", id);
	}

	public JSONArray getPhoneBook() {
		JSONObject json;
		JSONArray jsonArr = new JSONArray();
		try {
			Connection conn = jdbcTemplate.getDataSource().getConnection();
			Statement stmt = conn.createStatement(); //WHERE (dbtest."PHONENUMBERS"."ID_PERSON" = 4)
			String sql = "SELECT * FROM dbtest.phonenumbers WHERE (dbtest.phonenumbers.\"ID_PERSON\" = 3);";// LEFT JOIN dbtest.\"PERSONS\" ON dbtest.\"PERSONS\".\"ID\" = 4;"; // TODO not right sql
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				json = new JSONObject();
				json.put("name", rs.getString("ID_PERSON"));
				json.put("value", rs.getString("VALUE"));
				jsonArr.put(json);
			}
		} catch (SQLException e) {
			e.getLocalizedMessage();
			return null;
		} catch (JSONException e) {
			e.getLocalizedMessage();
			return null;
		}
		return jsonArr;
	}
}