   M S B A M L   `   `   `  ����H  DMuffinManager, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null9!clr-namespace:MuffinManager.VistaMuffinManager.Vista  5   	   4    .MuffinManager.Vista.MenuProductoTerminadoVista   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   3local!clr-namespace:MuffinManager.Vista     5   	     � Title$  Producto Terminado��5      $	��450��6(   $	��600��65    � 	Resources 5	         estiloBotones �� 
TargetType �� Property �� Value��%�   &	        �� 5
   
   " ��6&   .�5      ��  � ��$
 20pxq�6'   �� 5       � ��$
 Bold"�6+   �� 5       � ��$ 	50px,20pxq�6(   �� 5       � ��$
 15px(�6)   5      5      .��5      � 
���\\��.+�5   
   � -   5         �Name$ header��5       � RowDefinitions 5      �� 5      $��1* �6    �� 5      $��5* �6    .+�5      ]� $��0��6   .+�5      `� $	��Top=�6   $
��25px��64   .�5      c� .@�5      o� .@�5      m� $��Archivo��6'   $
��10px(�68   .@�5   "   m� $��Cerrar Sesión��6+    m� Command 6B   �� *CerrarSesionBtn+5      5      5      5       �� 5"      -   5         ��Name$ headerTitle��5"      $��MENU PRODUCTO TERMINADO��61   $��Center=�6P   $��Center=�6m   $
��Bold"�6�   $
��30px(�6�   5#      � 5%      -   5        $ content��5%      $��1��6$   	 � ColumnDefinitions	 5&      �� 5'      $��3* �6'   �� 5(      $��2* �6'   .+�5*      �� -   5        
 ��Name$
 buttonsContainer��5*   :   $��Center=�6   $��Center=�6T   $��0��6o   .+�5+      �� -   5         ��Name$ stockBtn��5+      ${�False��6/   $��STOCK��6A   #��[  6Q   ��6x   �� *
StockPTBtn+�� 5,      -   5        $ 
gestionBtn��5,      $��GESTIONAR DATOS��61   #��[  6K   ��6r   �� *GestionPTBtn+5-      �� 5.      -   5         ��Name$ logoMDLH��5.      $!��/Recursos/Imagenes/logo.png��6*   $��1��6O   $��	20px,30pxq�6_   $��Center=�6r   $��Center=�6�   5/      50      51      52      