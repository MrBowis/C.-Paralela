#include <omp.h>
#include <iostream>
#include <sys/time.h>
#include <stdio.h>
#include <math.h>
#include <conio.h>
#include <windows.h>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <algorithm>
#include <fstream>

#define RESET "\033[0m"
#define RED "\033[31m"
#define GREEN "\033[32m"
#define BLUE "\033[34m"

#define HIDE_CURSOR "\033[?25l"
#define SHOW_CURSOR "\033[?25h"

#define UP 72
#define DOWN 80
#define ENTER 13

double TR, TP;

void gotoxy(int x, int y);
int generarNumeroAleatorio(int min, int max);
std::vector<int> generarArreglo(int n);
int menu(const char *titulo, const char *opciones[], int n);
int busquedaBinariaR(const std::vector<int> &arr, int target, int left, int right);
bool busquedaBinariaP(std::vector<int> &arr, int target, int inicio, int final);

// Función auxiliar para realizar el intercambio de elementos en el arreglo
void swap(int &a, int &b)
{
    int temp = a;
    a = b;
    b = temp;
}

// Función auxiliar para realizar la partición del arreglo en torno a un pivote
int partition(std::vector<int> &arr, int low, int high)
{
    int pivot = arr[high]; // Tomar el último elemento como pivote
    int i = (low - 1);     // Índice del menor elemento

    for (int j = low; j <= high - 1; j++)
    {
        // Si el elemento actual es menor o igual al pivote
        if (arr[j] <= pivot)
        {
            i++;
            swap(arr[i], arr[j]);
        }
    }

    // Colocar el pivote en su posición correcta
    swap(arr[i + 1], arr[high]);
    return (i + 1);
}

// Función principal de QuickSort
void quickSort(std::vector<int> &arr, int low, int high)
{
    if (low < high)
    {
        // Encontrar el índice de partición
        int pi = partition(arr, low, high);

        // Ordenar los elementos antes y después de la partición
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int main()
{
    std::ofstream p;
    p.open("p.txt");
    std::ofstream s;
    s.open("s.txt");

    std::srand((std::time(0)));
    std::cout << HIDE_CURSOR;

    bool salir = false;
    int resultado;
    int opcion;

    int numeroElementos = 1000000;
    int key;

    struct timeval t0, t1;
    double tiempoP = 0;
    double tiempoS = 0;

    const char *titulo = "BUSQUEDA BINARIA";
    const char *opciones[] = {"Secuencial y Paralela",
                              "Busqueda Binaria (Secuencial)",
                              "Busqueda Binaria (Paralela)",
                              "Salir"};
    int n = 4;

    while (!salir)
    {
        opcion = menu(titulo, opciones, n);
        std::vector<int> A = generarArreglo(numeroElementos);
        std::vector<int> B = A;
        key = generarNumeroAleatorio(1, numeroElementos);
        system("cls");
        switch (opcion)
        {
        case 1:

            std::cout << "Numero a buscar: " << key << std::endl;
            gettimeofday(&t0, 0);
            // std::sort(A.begin(), A.end());
            quickSort(B, 0, B.size() - 1);
            busquedaBinariaP(B, key, 0, B.size() - 1);
            gettimeofday(&t1, 0);
            tiempoP = (t1.tv_sec - t0.tv_sec) + (t1.tv_usec - t0.tv_usec) / 1000000.0f;
            TP = tiempoP;
            printf("Tiempo de ejecucion (paralelo): %1.3f ms\n", TP * 1000);
            p << TP * 1000 << std::endl;

            std::cout << "Numero a buscar: " << key << std::endl;
            gettimeofday(&t0, 0);
            // std::sort(A.begin(), A.end());
            quickSort(A, 0, A.size() - 1);
            busquedaBinariaR(A, key, 0, A.size() - 1);
            gettimeofday(&t1, 0);
            tiempoS = (t1.tv_sec - t0.tv_sec) + (t1.tv_usec - t0.tv_usec) / 1000000.0f;
            TR = tiempoS;
            printf("Tiempo de ejecucion (Secuencial): %1.3f ms\n", TR * 1000);
            s << TR * 1000 << std::endl;

            system("pause");
            break;
        case 2:
            std::cout << "Numero a buscar: " << key << std::endl;
            gettimeofday(&t0, 0);
            // std::sort(A.begin(), A.end());
            quickSort(A, 0, A.size() - 1);
            busquedaBinariaR(A, key, 0, A.size() - 1);
            gettimeofday(&t1, 0);
            tiempoP = (t1.tv_sec - t0.tv_sec) + (t1.tv_usec - t0.tv_usec) / 1000000.0f;
            TR = tiempoP;
            printf("Tiempo de ejecucion (Secuencial): %1.3f ms\n", TR * 1000);
            system("pause");
            break;
        case 3:
            std::cout << "Numero a buscar: " << key << std::endl;
            gettimeofday(&t0, 0);
            // std::sort(A.begin(), A.end());
            quickSort(A, 0, A.size() - 1);
            std::cout << busquedaBinariaP(A, key, 0, A.size() - 1);
            gettimeofday(&t1, 0);
            tiempoP = (t1.tv_sec - t0.tv_sec) + (t1.tv_usec - t0.tv_usec) / 1000000.0f;
            TP = tiempoP;
            printf("Tiempo de ejecucion (paralelo): %1.3f ms\n", TP * 1000);
            system("pause");
            break;
        case 4:
            salir = true;
            break;
        }
    }

    system("cls");
    std::cout << SHOW_CURSOR;
    return 0;
}

int menu(const char *titulo, const char *opciones[], int n)
{
    int opcion = 1;
    int tecla;
    bool salir = false;

    while (!salir)
    {
        system("cls");
        gotoxy(5, 3 + opcion);
        std::cout << RED << ">>" << RESET;
        gotoxy(15, 2);
        std::cout << GREEN << titulo << RESET;
        for (int i = 0; i < n; i++)
        {
            gotoxy(10, 4 + i);
            std::cout << BLUE << i + 1 << ") " << RESET << opciones[i];
        }
        do
        {
            tecla = getch();
        } while (tecla != UP && tecla != DOWN && tecla != ENTER);

        switch (tecla)
        {
        case UP: // Arriba
            opcion--;
            if (opcion < 1)
            {
                opcion = n;
            }
            break;
        case DOWN: // Abajo
            opcion++;
            if (opcion > n)
            {
                opcion = 1;
            }
            break;
        case ENTER: // Enter
            salir = true;
            break;
        }
    }
    gotoxy(0, 0);
    return opcion;
}

void gotoxy(int x, int y)
{
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

std::vector<int> generarArreglo(int n)
{
    std::vector<int> A;
    int num;
    for (int i = 0; i < n; i++)
    {
        num = generarNumeroAleatorio(1, n);
        A.push_back(num);
    }
    return A;
}

int generarNumeroAleatorio(int min, int max)
{
    return (std::rand() % max + min);
}

bool busquedaBinariaP(std::vector<int> &arr, int target, int inicio, int final)
{
    int hilos = 8;
    int idHilo = 0;
    omp_set_num_threads(hilos);
    int mid = final / 2;
    int respuesta1, respuesta2, respuesta3, respuesta4;

#pragma omp parallel private(idHilo) num_threads(hilos)
    {
        idHilo = omp_get_thread_num();
        // std::cout << "Hilo: " << idHilo << std::endl;
        if (idHilo >= 0 && idHilo < hilos / 4)
            respuesta1 = busquedaBinariaR(arr, target, inicio, final / 4);
        if (idHilo >= hilos / 4 && idHilo < hilos / 2)
            respuesta2 = busquedaBinariaR(arr, target, final / 4, final / 2);
        if (idHilo >= hilos / 2 && idHilo < hilos * 3 / 4)
            respuesta3 = busquedaBinariaR(arr, target, final / 2, final * 3 / 4);
        if (idHilo >= hilos * 3 / 4 && idHilo < hilos)
            respuesta4 = busquedaBinariaR(arr, target, final * 3 / 4, final);
    }

    return respuesta1 || respuesta2;
}

int busquedaBinariaR(const std::vector<int> &arr, int target, int left, int right)
{
    int mid;
    if (left <= right)
    {
        mid = left + (right - left) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            return busquedaBinariaR(arr, target, mid + 1, right);
        else
            return busquedaBinariaR(arr, target, left, mid - 1);
    }
    return -1;
}