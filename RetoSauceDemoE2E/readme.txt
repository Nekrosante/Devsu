Reto Sauce Demo E2E

Realizado por:
Luis Miguel Arcia Moreno

Requerimientos:
- IntelliJ IDEA 2021.3.2 (Community Edition)
- Gradle 7.4.1
- Java 1.8.0
- Mozilla Firefox Versión 120.0 (64-bit)

Descripción:
El siguiente proyecto tiene como objetivo la ejecución automatizada del flujo de compra de la página SwagLabs, especificado en el caso de prueba CP01 relatado a continuación.

CP01
Nombre: Compra de dos productos en SwagLabs
Pasos:
	1.Acceder a la página SWAGLABS e ingresar con credenciales válidas.
	2.Agregar al carrito de compras dos productos usando el botón ADD TO CARD.
	3.Dirigirse al carrito de compras por medio del botón.
	4.Rellenar la información para completar la compra.
	5.Finalizar la compra.
Resultado esperado: Se debe mostrar la página CHECKOUT: COMPLETE! que aprueba la compra visualizando el mensaje THANK YOU FOR YOUR ORDER.

PASOS PARA LA EJECUCIÓN:
	1.Descomprimir el archivo E2E2.zip en la ruta deseada.
	2.Desde el software IntelliJ IDEA ir a File>>Open.
	3.En la ventana emergente, introducir la ruta donde se descomprimió el archivo .zip previamente.
	4.Seleccionar la carpeta RetoSauceDemoE2E.
	5.En la ventana emergente seleccionar la opción “Trust the Project”.
	6.En la parte superior derecha dar clic en el icono de “Build Project” u oprimir Ctrl + F9.
	7.Buscar el archivo swagLabs.feature en la ruta “RetoSauceDemoE2E/src/test/resources/features/purchase.feature” del proyecto cargado en la parte derecha de la ventana de Intellij
	8.Clic derecho sobre el archivo “purchase.feature” y seleccionar la opción Run: “Features: purchase”
