using MuffinManager.Vista;
using MuffinManager.Vista.Gestion.Elementos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using CommunityToolkit.Mvvm.Input;

namespace MuffinManager.VistaModelo.Gestion
{
    internal class GestionProductoTerminadoVistaModelo
    {
        private GestionProductoTerminadoVista ventana;
        private ICommand articuloBtn;
        private ICommand marcaBtn;
        private ICommand productoBtn;
        private ICommand formaBtn;
        private ICommand cajaBtn;
        private ICommand impresionPaqueteBtn;
        private ICommand volverBtn;

        public ICommand ArticuloBtn { get { return articuloBtn; } }
        public ICommand MarcaBtn { get { return marcaBtn; } }
        public ICommand ProductoBtn { get { return productoBtn; } }
        public ICommand FormaBtn { get { return formaBtn; } }
        public ICommand CajaBtn { get { return cajaBtn; } }
        public ICommand ImpresionPaqueteBtn { get { return impresionPaqueteBtn; } }
        public ICommand VolverBtn { get { return volverBtn; } }


        public GestionProductoTerminadoVistaModelo(GestionProductoTerminadoVista ventana)
        {
            this.ventana = ventana;
            this.articuloBtn = new RelayCommand(abrirGestionArticulo);
            this.marcaBtn = new RelayCommand(abrirGestionMarca);
            this.productoBtn = new RelayCommand(abrirGestionProducto);
            this.formaBtn = new RelayCommand(abrirGestionForma);
            this.cajaBtn = new RelayCommand(abrirGestionCaja);
            this.impresionPaqueteBtn = new RelayCommand(abrirGestionImpresionPaquete);
            this.volverBtn = new RelayCommand(volver);
        }

        private void volver()
        {
            MenuProductoTerminadoVista menuProductoTerminado = new MenuProductoTerminadoVista();
            menuProductoTerminado.Show();
            ventana.Close();
        }

        private void abrirGestionArticulo()
        {
            GestionArticuloVista gestionArticulo = new GestionArticuloVista();
            gestionArticulo.Show();
            ventana.Close();
        }

        private void abrirGestionMarca()
        {
            GestionMarcaVista gestionMarca = new GestionMarcaVista();
            gestionMarca.Show();
            ventana.Close();
        }

        private void abrirGestionProducto()
        {
            GestionProductoVista gestionProducto = new GestionProductoVista();
            gestionProducto.Show();
            ventana.Close();
        }

        private void abrirGestionForma()
        {
            GestionFormaVista gestionForma = new GestionFormaVista();
            gestionForma.Show();
            ventana.Close();
        }

        private void abrirGestionCaja()
        {
            GestionCajaVista gestionCaja = new GestionCajaVista();
            gestionCaja.Show();
            ventana.Close();
        }

        private void abrirGestionImpresionPaquete()
        {
            GestionImpresionPaqueteVista impresionPaquete = new GestionImpresionPaqueteVista();
            impresionPaquete.Show();
            ventana.Close();
        }
    }
}
