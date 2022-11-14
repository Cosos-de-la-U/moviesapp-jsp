function estadoModal(url){
    Swal.fire({
        title: '¿Desea cambiar el estado?',
        showDenyButton: true,
        showCancelButton: true,
        confirmButtonText: 'Cambiar',
        denyButtonText: `No cambiar`,
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            Swal.fire('¡Fue cambiado!', '', 'success')
            window.location.replace(url);
        } else if (result.isDenied) {
            Swal.fire('No fue cambiado', '', 'info')
        }
    })
}