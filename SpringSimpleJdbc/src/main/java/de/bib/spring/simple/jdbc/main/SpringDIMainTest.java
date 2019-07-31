package de.bib.spring.simple.jdbc.main;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.bib.spring.simple.jdbc.dao.ProductDao;
import de.bib.spring.simple.jdbc.model.Product;

/**
 * Main class for Spring Dependency Injection By Construction atau Method
 * Setter.
 * 
 * @author User
 *
 */
public class SpringDIMainTest {

	public static void main(String[] args) throws SQLException {
		System.out.println("Dependncy Injection Manual Test");

		/** instant product class. */
//		Product p = new Product();
//		p.setKodeProduct(0001);
//		p.setNameProduct("Buku Tulis");
//		p.setDescProduct("Buku Tulis Bergaris");
//		p.setUnitProduct("Pack");
//		p.setHargaProduct(new BigDecimal(35000.00));

		ApplicationContext context = new ClassPathXmlApplicationContext("config-ioc.xml");

		Product p = (Product) context.getBean("product");
		System.out.println("Kode Product : " + p.getKodeProduct());

		ProductDao pDAO = (ProductDao) context.getBean("productDao");
		pDAO.simpan(p);

	}
}
