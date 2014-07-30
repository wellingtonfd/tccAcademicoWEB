package ui.bean;

import entity.TipoMaterial;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoMaterialController")
@ViewScoped
public class TipoMaterialController extends AbstractController<TipoMaterial> {

    @Inject
    private EpeController epeCollectionController;
    @Inject
    private EmbalagemController embalagemCollectionController;
    @Inject
    private EpiController epiCollectionController;

    public TipoMaterialController() {
        // Inform the Abstract parent controller of the concrete TipoMaterial?cap_first Entity
        super(TipoMaterial.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Epe entities that are
     * retrieved from TipoMaterial?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Epe page
     */
    public String navigateEpeCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Epe_items", this.getSelected().getEpeCollection());
        }
        return "/entity/epe/index";
    }

    /**
     * Sets the "items" attribute with a collection of Embalagem entities that
     * are retrieved from TipoMaterial?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Embalagem page
     */
    public String navigateEmbalagemCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Embalagem_items", this.getSelected().getEmbalagemCollection());
        }
        return "/entity/embalagem/index";
    }

    /**
     * Sets the "items" attribute with a collection of Epi entities that are
     * retrieved from TipoMaterial?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Epi page
     */
    public String navigateEpiCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Epi_items", this.getSelected().getEpiCollection());
        }
        return "/entity/epi/index";
    }

}
