/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTutorial.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import myTutorial.model.themeName;

/**
 *
 * @author mspace
 */
@ManagedBean
@RequestScoped
public class Theme {

    String themename = "cupertino";
    private List<themeName> themes = new ArrayList<>();

    public String getThemename() {
//        Map klpd = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//        if (klpd.containsKey("myPrimeTheme")) {
//            themename = klpd.get("myPrimeTheme").toString();
//        }
        return themename;
    }

    public void setThemename(String themename) {
//        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("myPrimeTheme", themename);
        this.themename = themename;
    }

    public List<themeName> getThemes() {
        themes.add(new themeName("afterdark"));
        themes.add(new themeName("afternoon"));
        themes.add(new themeName("afterwork"));
        themes.add(new themeName("black-tie"));
        themes.add(new themeName("blitzer"));
        themes.add(new themeName("bluesky"));
        themes.add(new themeName("bootstrap"));
        themes.add(new themeName("casablanca"));
        themes.add(new themeName("cruze"));
        themes.add(new themeName("cupertino"));
        themes.add(new themeName("dark-hive"));
        themes.add(new themeName("dot-luv"));
        themes.add(new themeName("eggplant"));
        themes.add(new themeName("excite-bike"));
        themes.add(new themeName("flick"));
        themes.add(new themeName("glass-x"));
        themes.add(new themeName("home"));
        themes.add(new themeName("hot-sneaks"));
        themes.add(new themeName("humanity"));
        themes.add(new themeName("le-frog"));
        themes.add(new themeName("midnight"));
        themes.add(new themeName("mint-choc"));
        themes.add(new themeName("pepper-grinder"));
        themes.add(new themeName("redmond"));
        themes.add(new themeName("rocket"));
        themes.add(new themeName("sam"));
        themes.add(new themeName("smoothness"));
        themes.add(new themeName("south-street"));
        themes.add(new themeName("start"));
        themes.add(new themeName("sunny"));
        themes.add(new themeName("swanky-purse"));
        themes.add(new themeName("trontastic"));
        themes.add(new themeName("ui-darkness"));
        themes.add(new themeName("ui-lightness"));
        themes.add(new themeName("vader"));
        themes.add(new themeName("aristo"));
        return themes;
    }

    public void setThemes(List<themeName> themes) {
        this.themes = themes;
    }

    /**
     * Creates a new instance of Theme
     */
    public Theme() {
    }
}
