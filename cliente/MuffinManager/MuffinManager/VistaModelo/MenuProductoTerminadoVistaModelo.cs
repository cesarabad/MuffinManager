using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Input;
using CommunityToolkit.Mvvm.Input;
using MuffinManager.Vista;

namespace MuffinManager.VistaModelo
{
    internal class MenuProductoTerminadoVistaModelo
    {

        private MenuProductoTerminadoVista ventana;
        private ICommand stockPTBtn;
        private ICommand gestionPTBtn;

        public event PropertyChangedEventHandler? PropertyChanged;

        public ICommand StockPTBtn
        {
            get
            {
                return stockPTBtn;
            }

        }
        public ICommand GestionPTBtn
        {
            get
            {
                return gestionPTBtn;
            }
        }

        public MenuProductoTerminadoVistaModelo(MenuProductoTerminadoVista ventana)
        {
            this.ventana = ventana;
            stockPTBtn = new RelayCommand(abrirStockPT);
            gestionPTBtn = new RelayCommand(abrirGestionPT);
        }

        private void abrirStockPT()
        {
            StockProductoTerminadoVista stockPT = new StockProductoTerminadoVista();
            stockPT.Show();
            ventana.Close();
        }

        private void abrirGestionPT()
        {
            GestionProductoTerminadoVista gestionPT = new GestionProductoTerminadoVista();
            gestionPT.Show();
            ventana.Close();
        }

    }
}
