package org.legend.entity;

import java.util.*;

public class AllCollectionType {
    private List<String> listElement;
    private String[] arrayElement;
    private Set<String> setElement;
    private Map<String, String> mapElement;
    private Properties propsElement;

    public AllCollectionType(Properties propsElement) {
        this.propsElement = propsElement;
    }

    public List<String> getListElement() {
        return listElement;
    }

    public void setListElement(List<String> listElement) {
        this.listElement = listElement;
    }

    public String[] getArrayElement() {
        return arrayElement;
    }

    public void setArrayElement(String[] arrayElement) {
        this.arrayElement = arrayElement;
    }

    public Set<String> getSetElement() {
        return setElement;
    }

    public void setSetElement(Set<String> setElement) {
        this.setElement = setElement;
    }

    public Map<String, String> getMapElement() {
        return mapElement;
    }

    public void setMapElement(Map<String, String> mapElement) {
        this.mapElement = mapElement;
    }

    public Properties getPropsElement() {
        return propsElement;
    }

    public void setPropsElement(Properties propsElement) {
        this.propsElement = propsElement;
    }

    @Override
    public String toString() {
        String strContent = "";
        for(String str: this.getArrayElement()) {
            strContent += str + ",";
        }
        return
                "list:" + this.getListElement() + ",\n" +
                        "array:" + strContent + ",\n" +
                        "set:" + this.getSetElement() + ",\n" +
                        "map:" + this.getMapElement() + ",\n" +
                        "properties:" + this.getPropsElement();
    }
}
