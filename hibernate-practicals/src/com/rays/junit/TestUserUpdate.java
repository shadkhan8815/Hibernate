package com.rays.junit;

import org.junit.Test;

import junit.framework.TestCase;

public class TestUserUpdate extends TestCase {

	@Test
	public void testUpdate() throws Exception {

		UserBean bean = UserModel.findByPk(6);

		bean.setName("Chetan");

		UserModel.update(bean);

		bean = UserModel.findByPk(6);

		assertEquals("Astik", bean.getName());
	}
}