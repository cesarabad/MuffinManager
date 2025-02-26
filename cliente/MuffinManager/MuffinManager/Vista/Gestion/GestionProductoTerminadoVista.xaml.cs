using MuffinManager.VistaModelo.Gestion;
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

namespace MuffinManager.Vista
{
    /// <summary>
    /// Lógica de interacción para GestionProductoTerminadoVista.xaml
    /// </summary>
    public partial class GestionProductoTerminadoVista : Window
    {
        private GestionProductoTerminadoVistaModelo vistaModelo;
        public GestionProductoTerminadoVista()
        {
            InitializeComponent();
            vistaModelo = new GestionProductoTerminadoVistaModelo(this);
            this.DataContext = vistaModelo;
        }
    }
}
