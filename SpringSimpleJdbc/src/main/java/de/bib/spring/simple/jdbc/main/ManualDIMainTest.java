package de.bib.spring.simple.jdbc.main;

import java.math.BigDecimal;
import java.sql.SQLException;

import de.bib.spring.simple.jdbc.dao.ProductDao;
import de.bib.spring.simple.jdbc.model.Product;
import de.bib.spring.simple.jdbc.util.ResourceDatabase;

/**
 * Main class for testing manual dependency injection.
 * 
 * @author User
 *
 */
public class ManualDIMainTest {

	public static void main(String[] args) throws Exception {
		ResourceDatabase rd = new ResourceDatabase();
		ProductDao pDao = new ProductDao(rd.getdSrc());

		System.out.println("Dependncy Injection Manual Test");

		/** instant product class. */
		Product p = new Product();
//		p.setKodeProduct(0002);
//		p.setNameProduct("Buku Gambar");
//		p.setDescProduct("Buku Gambar");
//		p.setUnitProduct("Pack");
//		p.setHargaProduct(new BigDecimal(55000.00));
//

		/** Insert new product. */
//		try {
//			pDao.simpan(p);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Error, insert data");
//		}

		/** Get product by kode_product. */
//		try {
//			p = pDao.cariById(2);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Error, Get data");
//		}
//		System.out.println("Kode_Product :" + p.getKodeProduct() + " , Nama_Product :" + p.getNameProduct());

		/** Delete product by kode_product. */
		try {
			pDao.deleteById(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error, Delete data");
		}
		System.out.println("Delete product sukses");
		System.out.println("Finish");
	}

}
