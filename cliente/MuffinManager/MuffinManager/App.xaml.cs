using MuffinManager.Vista;
using MuffinManager.Vista.Login;
using System.Configuration;
using System.Data;
using System.Net.Http;
using System.Windows;

namespace MuffinManager
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        protected override async void OnStartup(StartupEventArgs e)
        {
            base.OnStartup(e);
            if (await EsTokenValido())
            {
                MenuProductoTerminadoVista menuProductoTerminadoVista = new MenuProductoTerminadoVista();
                menuProductoTerminadoVista.Show();
            } else
            {
                LoginVista loginVista = new LoginVista();
                loginVista.Show();
            }
        }

        private async Task<bool> EsTokenValido()
        {
            String? token = ConfigurationManager.AppSettings["token"];

            if (string.IsNullOrEmpty(token))
            {
                return false;
            }

            try
            {
                using (HttpClient cliente = new HttpClient())
                {
                    
                    cliente.DefaultRequestHeaders.Authorization = new System.Net.Http.Headers.AuthenticationHeaderValue("Bearer", token);
                    HttpResponseMessage respuesta = await cliente.GetAsync("http://localhost:8080/auth");
                    return respuesta.IsSuccessStatusCode;
                }
            }
            catch (Exception)
            {
                MessageBox.Show("Error al validar el usuario");
                return false;
            }

        }

        
    }

}
