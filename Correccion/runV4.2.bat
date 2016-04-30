set salida=Salida\%IDGRUPO%_SalidaV4.2.txt
echo INFORME DE CORRECCION VERSION V4.2 >%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV4.1.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV4.2\%BinFolder% CMain comandos\comandosV4.1.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV4.2.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV4.2\%BinFolder% CMain comandos\comandosV4.2.txt >>%salida%
