package ui.bean;

import entity.Pais;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "paisController")
@ViewScoped
public class PaisController extends AbstractController<Pais> {

    @Inject
    private EnderecoController enderecoCollectionController;

    public PaisController() {
        // Inform the Abstract parent controller of the concrete Pais?cap_first Entity
        super(Pais.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Endereco entities that
     * are retrieved from Pais?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Endereco page
     */
    public String navigateEnderecoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Endereco_items", this.getSelected().getEnderecoCollection());
        }
        return "/entities/endereco/index";
    }

}
