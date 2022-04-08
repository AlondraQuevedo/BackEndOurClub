package com.generation.ourClub;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.generation.ourClub.model.Producto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;




import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc

class OurClubApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	//@Disabled("desabilitado temporalmente")
//modificar producto
	public void pruebaPut() throws Exception {
			this.mockMvc.perform(put("/api/productos/422").queryParam("nombre", "Nuevo Adidas Games Of Thrones Ultra Boost ")
					.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c3VhcmlvMkBnbWFpbC5jb20iLCJyb2xlIjoidXNlciIsImlhdCI6MTY0OTM4NDkwNiwiZXhwIjoxNjQ5NDIwOTA2fQ.6XPShp4gjNTN57jldHrCDM97wrEEKeGFWN_3XWWT2nM"))
			.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Adidas")));
		

	}// pruebaput(modifica los campos 
	
	
	
	@Test
	@Disabled("desabilitado temporalmente")
	public void pruebaDelete() throws Exception {
			this.mockMvc.perform(delete("/api/productos/423").header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c3VhcmlvMkBnbWFpbC5jb20iLCJyb2xlIjoidXNlciIsImlhdCI6MTY0OTM4NDkwNiwiZXhwIjoxNjQ5NDIwOTA2fQ.6XPShp4gjNTN57jldHrCDM97wrEEKeGFWN_3XWWT2nM"))
			.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Gifts")));
		

	}// pruebadelete

	

	@Test
@Disabled("desabilitado temporalmente")
	public void pruebaPost() throws Exception {
		Producto p = new Producto();
		p.setNombre("Adidas F30 taquete de colores");
		p.setDescripcion("Está diseñado con una mejor forma alrededor del cuello y la lengüeta para ayudar a mantener el pie");
		p.setTalla(25);
		p.setPrecio(1800);
		p.setExistencia(13);
		p.setURL_imagen("Adidas F30 taquete de colores.jpg");
	
		
		this.mockMvc.perform( post("/api/productos/").header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c3VhcmlvMkBnbWFpbC5jb20iLCJyb2xlIjoidXNlciIsImlhdCI6MTY0OTM4NDkwNiwiZXhwIjoxNjQ5NDIwOTA2fQ.6XPShp4gjNTN57jldHrCDM97wrEEKeGFWN_3XWWT2nM")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(p))).andExpect(status().isOk());
	}//pruebaPost
	
	public static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
 } // asJsonString

	
	
	@Test
	@Disabled("desabilitado temporalmente")
	public void pruebaGets() throws Exception {
		Producto p= new Producto();
		this.mockMvc.perform(get("/api/productos/425")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Uncaget")));
		this.mockMvc.perform(get("/api/productos/425")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(" Boost")));
		this.mockMvc.perform(get("/api/productos/425")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(" Ultra")));

	}// pruebaGets

	
	@Test
@Disabled("desabilitado temporalmente")
	public void preba404() throws Exception {
		this.mockMvc.perform(get("/api/producto/421")).andDo(print()).andExpect(status().isNotFound());
	}// prueba400
}// class
