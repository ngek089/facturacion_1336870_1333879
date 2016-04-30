set salida=Salida\%IDGRUPO%_SalidaV3.txt
echo INFORME DE CORRECCION VERSION V3 >%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV2.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV3\%BinFolder% CMain comandos\comandosV2.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV3.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV3\%BinFolder% CMain comandos\comandosV3.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV3.1.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV3\%BinFolder% CMain comandos\comandosV3.1.txt >>%salida%
