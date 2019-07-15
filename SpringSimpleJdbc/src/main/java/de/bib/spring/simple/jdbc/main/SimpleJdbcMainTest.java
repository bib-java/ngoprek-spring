package de.bib.spring.simple.jdbc.main;

import java.math.BigDecimal;
import java.sql.SQLException;

import de.bib.spring.simple.jdbc.dao.ProductDao;
import de.bib.spring.simple.jdbc.model.Product;
import de.bib.spring.simple.jdbc.util.ResourceDatabase;

public class SimpleJdbcMainTest {

	public static void main(String[] args) throws Exception {
		ResourceDatabase rd = new ResourceDatabase();

		System.out.println("Dependncy Injection Manual Test");
		Product p = new Product();
		p.setKodeProduct(0001);
		p.setNameProduct("Buku Tulis");
		p.setDescProduct("Buku Tulis Bergaris");
		p.setUnitProduct("Pack");
		p.setHargaProduct(new BigDecimal(35000.00));

		ProductDao pDao = new ProductDao(rd.getConnection());
		try {
			pDao.simpan(p);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error, insert data");
		}

		System.out.println("Finish");
	}

}
