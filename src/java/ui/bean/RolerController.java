package ui.bean;

import entity.Roler;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "rolerController")
@ViewScoped
public class RolerController extends AbstractController<Roler> {

    @Inject
    private UsuarioController usuarioCollectionController;

    public RolerController() {
        // Inform the Abstract parent controller of the concrete Roler?cap_first Entity
        super(Roler.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from Roler?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", this.getSelected().getUsuarioCollection());
        }
        return "/entities/usuario/index";
    }

}
