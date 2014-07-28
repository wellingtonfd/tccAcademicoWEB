package ui.bean;

import entity.Capacidade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "capacidadeController")
@ViewScoped
public class CapacidadeController extends AbstractController<Capacidade> {

    @Inject
    private EmbalagemController embalagemCollectionController;

    public CapacidadeController() {
        // Inform the Abstract parent controller of the concrete Capacidade?cap_first Entity
        super(Capacidade.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Embalagem entities that
     * are retrieved from Capacidade?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Embalagem page
     */
    public String navigateEmbalagemCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Embalagem_items", this.getSelected().getEmbalagemCollection());
        }
        return "/entities/embalagem/index";
    }

}
