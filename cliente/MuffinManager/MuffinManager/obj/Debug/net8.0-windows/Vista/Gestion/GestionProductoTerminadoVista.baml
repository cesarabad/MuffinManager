   M S B A M L   `   `   `  ����H  DMuffinManager, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null9!clr-namespace:MuffinManager.VistaMuffinManager.Vista  5   	   7    1MuffinManager.Vista.GestionProductoTerminadoVista   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   3local!clr-namespace:MuffinManager.Vista     5   	     � Title$#  GestionProductoTerminadoVista��5   	   $	��550��6/   $
��1000��6<    � 	Resources 5	         estiloBotones �� 
TargetType �� Property �� Value��%�   &	        �� 5
   
   " ��6&   .�5      ��  � ��$
 Bold"�6+   �� 5       � ��$
 15px(�6)   �� 5       � ��$ 	0px, 15pxq�6(   �� 5       � ��$ 20px,5pxq�6'   5      5      .��5      � 
���\\�� � RowDefinitions 5   
   �� 5      $��1* �6   �� 5      $��5* �6   .+�5   
   � $��0��6    � ColumnDefinitions 5      �� 5      $��1* �6#   �� 5      $��7* �6#   .+�5      �� -   5         ��Name$ 	volverBtn��5      $��Volver��6(   $��
10px, 20pxq�6W   $
��17px(�6k   ��69   �� *	VolverBtn+6k   �� 5      -   5         ��Name$ header��5      $��Center=�6(   $��Center=�6C   $
��Bold"�6`   $��1��6r   $
��29px(�6�   $"��ELEMENTOS PRODUCTO TERMINADO��6�   5      � 5   
   $��1��6    5       �� 5!      $��3* �6#   �� 5"      $��2* �6#   .+�5%      �� $��0��6   $��Center=�6)   .+�5&      �� -   5        $ articuloBtn��5&      $��ARTICULO��6.   #��[  6a   ��6A   �� *ArticuloBtn+6a   �� 5'      -   5        $ marcaBtn��5'      $��MARCA��6+   #��[  6;   ��6b   �� *
MarcaBtn+�� 5(      -   5        $ productoBtn��5(      $��PRODUCTO TERMINADO��6.   #��[  6K   ��6r   �� *ProductoBtn+�� 5)      -   5        $ formaBtn��5)      $��FORMA��6+   #��[  6X   ��6;   �� *
FormaBtn+6X   �� 5*      -   5        $ cajaBtn��5*      $
��CAJA��6*   #��[  69   ��6`   �� *	CajaBtn+�� 5+      -   5        $ impresionPaquete��5+      $��IMPRESION PAQUETE��63   #��[  6O   ��6v   �� *ImpresionPaqueteBtn+5,      �� 5-      $!��/Recursos/Imagenes/logo.png��6   $��1��69   $
��20pxq�6I   5.      5/      50      