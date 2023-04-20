package com.company.Builders;

import com.company.Builders.HouseBuilder;
import com.company.Product.House;

public class TreeHouseBuilder implements HouseBuilder
{
    private House house;

    public TreeHouseBuilder()
    {
        this.house = new House();
    }

    public void buildBasement()
    {
        house.setBasement("Wooden Poles");
    }

    public void buildStructure()
    {
        house.setStructure("Wood and Ice");
    }

    public void buildInterior()
    {
        house.setInterior("Fire Wood");
    }

    public void buildRoof()
    {
        house.setRoof("Wood, caribou and seal skins");
    }

    public House getHouse()
    {
        return this.house;
    }

}
