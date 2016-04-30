set salida=Salida\%IDGRUPO%_SalidaV1.1.txt
echo INFORME DE CORRECCION VERSION V1.1 >%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV1.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV1.1\%BinFolder% CMain comandos\comandosV1.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV1.1.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV1.1\%BinFolder% CMain comandos\comandosV1.1.txt >>%salida%

echo =================================================================== >>%salida%
echo Fichero de comandos comandosV2.txt >>%salida%
echo =================================================================== >>%salida%
java -cp FacturacionV1.1\%BinFolder% CMain comandos\comandosV2.txt >>%salida%
