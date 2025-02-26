using MuffinManager.VistaModelo;
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
    /// Lógica de interacción para MenuPrincipalVista.xaml
    /// </summary>
    public partial class MenuProductoTerminadoVista : Window
    {
        private MenuProductoTerminadoVistaModelo vistaModelo;
        public MenuProductoTerminadoVista()
        {
            InitializeComponent();
            vistaModelo = new MenuProductoTerminadoVistaModelo(this);
            this.DataContext = vistaModelo;
        }
    }
}
