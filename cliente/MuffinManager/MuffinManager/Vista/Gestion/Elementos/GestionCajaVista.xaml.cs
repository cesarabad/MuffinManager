﻿using MuffinManager.VistaModelo.Gestion.Elementos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace MuffinManager.Vista.Gestion.Elementos
{
    
    public partial class GestionCajaVista : Window
    {
        private GestionCajaVistaModelo vistaModelo;
        public GestionCajaVista(GestionProductoTerminadoVista ventanaAnterior)
        {
            InitializeComponent();
            vistaModelo = new GestionCajaVistaModelo(this, ventanaAnterior);
            this.DataContext = vistaModelo;
        }

        private async void Window_Loaded(object sender, RoutedEventArgs e)
        {
            await vistaModelo.CargarDatosAsync();
        }
    }
}
