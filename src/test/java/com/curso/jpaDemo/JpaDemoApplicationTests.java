package com.curso.jpaDemo;

import com.curso.jpaDemo.entidades.Auto;
import com.curso.jpaDemo.repositorio.AutoRepositorio;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@SpringBootTest
public class JpaDemoApplicationTests {

	@Autowired
	private AutoRepositorio autoRepositorio;

	@Test
	public void contextLoads() {
	}

	@Test
	public void probarCrearAuto() {
		Auto auto = new Auto();
		auto.setMarca("Volvo");
		auto.setModelo("Gol");
		auto.setPrecio(23000);
		Auto e = autoRepositorio.save(auto);
		Assert.assertEquals(e, auto);
	}

	@Test
	public void probarObtenerEntidad() {
		Optional<Auto> optional = autoRepositorio.findById(1L);
		Auto auto = optional.get();
		System.out.println(auto.getMarca());
	}

	@Test
	public void probarObtenerEntidades() {
		Iterable<Auto> autos = autoRepositorio.findAll();
		for (Auto a: autos) {
			System.out.println(a.getCodigo() + " "  +a.getMarca() + " " +a.getModelo());
			System.out.println("---------------------------");
		}
		Assert.assertNotNull(autos);
	}

}
