package dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="laptop_Details")
public class LaptopDetails implements Serializable{
	@Column(name="laptop_name")
	private String laptopName;
	@Column(name="processer")
	private String processer;
	@Column(name="ram")
	private Integer ram;
	@Id
	@GenericGenerator(name = "id_lp", strategy = "increment")
	@GeneratedValue(generator="id_lp")
	private Integer id;
	public LaptopDetails() {
		// TODO Auto-generated constructor stub
	}
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	public String getProcesser() {
		return processer;
	}
	public void setProcesser(String processer) {
		this.processer = processer;
	}
	public Integer getRam() {
		return ram;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "LaptopDetails [laptopName=" + laptopName + ", processer=" + processer + ", ram=" + ram + ", id=" + id
				+ "]";
	}
	
}
