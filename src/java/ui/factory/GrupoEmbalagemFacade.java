/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.factory;

import entity.GrupoEmbalagem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Stateless
public class GrupoEmbalagemFacade extends AbstractFacade<GrupoEmbalagem> {
    @PersistenceContext(unitName = "tccAcademicoWEBPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoEmbalagemFacade() {
        super(GrupoEmbalagem.class);
    }

}
