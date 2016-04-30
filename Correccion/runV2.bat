set salida=Salida\%IDGRUPO%_SalidaV2.txt
echo INFORME DE CORRECCION VERSION V2 >%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV1.1.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV2\%BinFolder% CMain comandos\comandosV1.1.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV2.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV2\%BinFolder% CMain comandos\comandosV2.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV3.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV2\%BinFolder% CMain comandos\comandosV3.txt >>%salida%
