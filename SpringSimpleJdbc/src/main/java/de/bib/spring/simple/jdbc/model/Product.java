package de.bib.spring.simple.jdbc.model;

import java.math.BigDecimal;

/**
 * Deskripsi terkait produk yang di jual
 * 
 * @author User
 *
 */
public class Product {

	/** Berisi-kan kode product. */
	private Integer kodeProduct;

	/** Berisi-kan name product. */
	private String nameProduct;

	/** Berisi-kan deskripsi dari product. */
	private String descProduct;

	/** Berisi-kan ukuran satuan dari product. */
	private String unitProduct;

	/** Berisi-kan harga dari product. */
	private BigDecimal hargaProduct;

	public Integer getKodeProduct() {
		return kodeProduct;
	}

	public void setKodeProduct(Integer kodeProduct) {
		this.kodeProduct = kodeProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDescProduct() {
		return descProduct;
	}

	public void setDescProduct(String descProduct) {
		this.descProduct = descProduct;
	}

	public String getUnitProduct() {
		return unitProduct;
	}

	public void setUnitProduct(String unitProduct) {
		this.unitProduct = unitProduct;
	}

	public BigDecimal getHargaProduct() {
		return hargaProduct;
	}

	public void setHargaProduct(BigDecimal hargaProduct) {
		this.hargaProduct = hargaProduct;
	}

}
