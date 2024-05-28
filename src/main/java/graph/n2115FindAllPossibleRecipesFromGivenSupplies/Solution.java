package graph.n2115FindAllPossibleRecipesFromGivenSupplies;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients,
      String[] supplies) {
    Map<String, Boolean> craftMemo = new HashMap<>();
    for (String supply : supplies) {
      craftMemo.put(supply, true);
    }

    Map<String, List<String>> r = new HashMap<>();
    for (int i = 0; i < recipes.length; i++) {
      r.put(recipes[i], ingredients.get(i));
    }

    List<String> reachableRecipes = new LinkedList<>();
    for (int i = 0; i < recipes.length; i++) {
      String recipe = recipes[i];
      if (canCraft(craftMemo, r, recipe)) {
        reachableRecipes.add(recipe);
      }
    }

    return reachableRecipes;
  }

  private boolean canCraft(Map<String, Boolean> craftMemo, Map<String, List<String>> recipes,
      String component) {

    Boolean craftResult = craftMemo.get(component);
    if (craftMemo.containsKey(component) && craftResult == null) {
      return false;
    }

    if (craftResult != null) {
      return craftResult;
    }
    craftMemo.put(component, null);

    List<String> subComponents = recipes.get(component);
    if (subComponents == null) {
      return false;
    }

    for (String subComponent : subComponents) {
      if (!canCraft(craftMemo, recipes, subComponent)) {
        craftMemo.put(component, false);
        return false;
      }
    }

    craftMemo.put(component, true);
    return true;

  }
}
