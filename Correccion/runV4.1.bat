set salida=Salida\%IDGRUPO%_SalidaV4.1.txt
echo INFORME DE CORRECCION VERSION V4.1 >%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV4.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV4.1\%BinFolder% CMain comandos\comandosV4.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV4.1.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV4.1\%BinFolder% CMain comandos\comandosV4.1.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV4.2.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV4.1\%BinFolder% CMain comandos\comandosV4.2.txt >>%salida%
