set salida=Salida\%IDGRUPO%_SalidaV3.1.txt
echo INFORME DE CORRECCION VERSION V3.1 >%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV3.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV3.1\%BinFolder% CMain comandos\comandosV3.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV3.1.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV3.1\%BinFolder% CMain comandos\comandosV3.1.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV4.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV3.1\%BinFolder% CMain comandos\comandosV4.txt >>%salida%
