set salida=Salida\%IDGRUPO%_SalidaV4.txt
echo INFORME DE CORRECCION VERSION V4 >%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV3.1.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV4\%BinFolder% CMain comandos\comandosV3.1.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV4.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV4\%BinFolder% CMain comandos\comandosV4.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV4.1.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV4\%BinFolder% CMain comandos\comandosV4.1.txt >>%salida%
