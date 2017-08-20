package com.callibrity.muffaletta.entity;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by MMiller on 19/8/2017 (Sat) at 20:39.
 */
public class DrinkForm {
	@NotEmpty
	private List<String> ingredients;

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
}
